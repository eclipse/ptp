/******************************************************************************
 * Copyright (c) 2005 The Regents of the University of California.
 * This material was produced under U.S. Government contract W-7405-ENG-36
 * for Los Alamos National Laboratory, which is operated by the University
 * of California for the U.S. Department of Energy. The U.S. Government has
 * rights to use, reproduce, and distribute this software. NEITHER THE
 * GOVERNMENT NOR THE UNIVERSITY MAKES ANY WARRANTY, EXPRESS OR IMPLIED, OR
 * ASSUMES ANY LIABILITY FOR THE USE OF THIS SOFTWARE. If software is modified
 * to produce derivative works, such modified software should be clearly
 * marked, so as not to confuse it with the version available from LANL.
 *
 * Additionally, this program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * LA-CC 04-115
 ******************************************************************************/

#include <mpi.h>
#include	<getopt.h>
#include <stdlib.h>
#include <stdarg.h>

#include "backend.h"

#define DEFAULT_BACKEND	"gdbmi"

extern void client(int);
extern void server(int, int, dbg_backend *);

static struct option longopts[] = {
	{"debugger",	required_argument,	NULL,	'b'},
	{"port",		required_argument,	NULL, 	'p'}, 
	{NULL,		0,					NULL,	0}
};

void
error_msg(int rank, char *fmt, ...)
{
	va_list	ap;
	
	if (rank != 0)
		return;
		
	va_start(ap, fmt);
	vfprintf(stderr, fmt, ap);
	va_end(ap);
}

/*
 * Main entry point for MPI parallel debugger.
 * 
 * @arg	-b debugger	select backend debugger
 * @arg	-p port		port number to listen on
 */
int
main(int argc, char *argv[])
{
	int 				rank;
	int 				size;
	int				ch;
	int				port;
	char *			debugger = DEFAULT_BACKEND;
	dbg_backend *	d;
	
	while ((ch = getopt_long(argc, argv, "b:p:", longopts, NULL)) != -1)
	switch (ch) {
	case 'b':
		debugger = optarg;
		break;
	case 'p':
		port = atoi(optarg);
		break;
	default:
		fprintf(stderr, "sdm [--debugger=value] [--port=list-port]\n");
		exit(1);
	}
	
	argc -= optind;
	argv += optind;
	
	MPI_Init(&argc, &argv);
	
	MPI_Comm_size(MPI_COMM_WORLD, &size);
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);
	
	// MPI_Comm_create_errhandler(handle_fatal_errors, &err_handler);
	// MPI_Comm_set_errhandler(MPI_COMM_WORLD, err_handler);
	
	/* Create multicast communicator */
	
	if (find_dbg_backend(debugger, &d) < 0) {
		error_msg(rank, "No such backend: \"%s\"\n", debugger);
		MPI_Finalize();
		return 1;
	}
	
	if (rank == size-1) {
		client(rank);
	} else {
		server(size - 1, rank, d);
	}
	
	MPI_Finalize();
	
	return 0;
}
