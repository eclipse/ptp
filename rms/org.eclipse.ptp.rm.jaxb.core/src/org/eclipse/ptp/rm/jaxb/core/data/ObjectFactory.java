//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.12 at 09:51:54 AM CST 
//

package org.eclipse.ptp.rm.jaxb.core.data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the org.eclipse.ptp.rm.jaxb.core.data package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _ControlSubmitInteractive_QNAME = new QName("http://org.eclipse.ptp/rm", "submit-interactive"); //$NON-NLS-1$ //$NON-NLS-2$
	private final static QName _ControlSubmitDebug_QNAME = new QName("http://org.eclipse.ptp/rm", "submit-debug"); //$NON-NLS-1$ //$NON-NLS-2$
	private final static QName _ControlSubmitBatch_QNAME = new QName("http://org.eclipse.ptp/rm", "submit-batch"); //$NON-NLS-1$ //$NON-NLS-2$
	private final static QName _ResourceManagerBuilder_QNAME = new QName("http://org.eclipse.ptp/rm", "resource-manager-builder"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: org.eclipse.ptp.rm.jaxb.core.data
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link Add }
	 * 
	 */
	public Add createAdd() {
		return new Add();
	}

	/**
	 * Create an instance of {@link Append }
	 * 
	 */
	public Append createAppend() {
		return new Append();
	}

	/**
	 * Create an instance of {@link Arg }
	 * 
	 */
	public Arg createArg() {
		return new Arg();
	}

	/**
	 * Create an instance of {@link Arglist }
	 * 
	 */
	public Arglist createArglist() {
		return new Arglist();
	}

	/**
	 * Create an instance of {@link AttributeGroup }
	 * 
	 */
	public AttributeGroup createAttributeGroup() {
		return new AttributeGroup();
	}

	/**
	 * Create an instance of {@link AttributeGroup.Include }
	 * 
	 */
	public AttributeGroup.Include createAttributeGroupInclude() {
		return new AttributeGroup.Include();
	}

	/**
	 * Create an instance of {@link ColumnData }
	 * 
	 */
	public ColumnData createColumnData() {
		return new ColumnData();
	}

	/**
	 * Create an instance of {@link Command }
	 * 
	 */
	public Command createCommand() {
		return new Command();
	}

	/**
	 * Create an instance of {@link Control }
	 * 
	 */
	public Control createControl() {
		return new Control();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Command }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://org.eclipse.ptp/rm", name = "submit-batch", scope = Control.class)
	public JAXBElement<Command> createControlSubmitBatch(Command value) {
		return new JAXBElement<Command>(_ControlSubmitBatch_QNAME, Command.class, Control.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Command }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://org.eclipse.ptp/rm", name = "submit-debug", scope = Control.class)
	public JAXBElement<Command> createControlSubmitDebug(Command value) {
		return new JAXBElement<Command>(_ControlSubmitDebug_QNAME, Command.class, Control.class, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Command }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://org.eclipse.ptp/rm", name = "submit-interactive", scope = Control.class)
	public JAXBElement<Command> createControlSubmitInteractive(Command value) {
		return new JAXBElement<Command>(_ControlSubmitInteractive_QNAME, Command.class, Control.class, value);
	}

	/**
	 * Create an instance of {@link DirectiveDefinition }
	 * 
	 */
	public DirectiveDefinition createDirectiveDefinition() {
		return new DirectiveDefinition();
	}

	/**
	 * Create an instance of {@link Entry }
	 * 
	 */
	public Entry createEntry() {
		return new Entry();
	}

	/**
	 * Create an instance of {@link EnvironmentVariable }
	 * 
	 */
	public EnvironmentVariable createEnvironmentVariable() {
		return new EnvironmentVariable();
	}

	/**
	 * Create an instance of {@link GridData }
	 * 
	 */
	public GridData createGridData() {
		return new GridData();
	}

	/**
	 * Create an instance of {@link GridLayout }
	 * 
	 */
	public GridLayout createGridLayout() {
		return new GridLayout();
	}

	/**
	 * Create an instance of {@link Group }
	 * 
	 */
	public Group createGroup() {
		return new Group();
	}

	/**
	 * Create an instance of {@link JobAttribute }
	 * 
	 */
	public JobAttribute createJobAttribute() {
		return new JobAttribute();
	}

	/**
	 * Create an instance of {@link LaunchTab }
	 * 
	 */
	public LaunchTab createLaunchTab() {
		return new LaunchTab();
	}

	/**
	 * Create an instance of {@link ManagedFile }
	 * 
	 */
	public ManagedFile createManagedFile() {
		return new ManagedFile();
	}

	/**
	 * Create an instance of {@link ManagedFiles }
	 * 
	 */
	public ManagedFiles createManagedFiles() {
		return new ManagedFiles();
	}

	/**
	 * Create an instance of {@link Match }
	 * 
	 */
	public Match createMatch() {
		return new Match();
	}

	/**
	 * Create an instance of {@link Monitor }
	 * 
	 */
	public Monitor createMonitor() {
		return new Monitor();
	}

	/**
	 * Create an instance of {@link Property }
	 * 
	 */
	public Property createProperty() {
		return new Property();
	}

	/**
	 * Create an instance of {@link Put }
	 * 
	 */
	public Put createPut() {
		return new Put();
	}

	/**
	 * Create an instance of {@link Read }
	 * 
	 */
	public Read createRead() {
		return new Read();
	}

	/**
	 * Create an instance of {@link Regex }
	 * 
	 */
	public Regex createRegex() {
		return new Regex();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link ResourceManagerData }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://org.eclipse.ptp/rm", name = "resource-manager-builder")
	public JAXBElement<ResourceManagerData> createResourceManagerBuilder(ResourceManagerData value) {
		return new JAXBElement<ResourceManagerData>(_ResourceManagerBuilder_QNAME, ResourceManagerData.class, null, value);
	}

	/**
	 * Create an instance of {@link ResourceManagerData }
	 * 
	 */
	public ResourceManagerData createResourceManagerData() {
		return new ResourceManagerData();
	}

	/**
	 * Create an instance of {@link Script }
	 * 
	 */
	public Script createScript() {
		return new Script();
	}

	/**
	 * Create an instance of {@link Set }
	 * 
	 */
	public Set createSet() {
		return new Set();
	}

	/**
	 * Create an instance of {@link Site }
	 * 
	 */
	public Site createSite() {
		return new Site();
	}

	/**
	 * Create an instance of {@link Style }
	 * 
	 */
	public Style createStyle() {
		return new Style();
	}

	/**
	 * Create an instance of {@link TabController }
	 * 
	 */
	public TabController createTabController() {
		return new TabController();
	}

	/**
	 * Create an instance of {@link TabFolder }
	 * 
	 */
	public TabFolder createTabFolder() {
		return new TabFolder();
	}

	/**
	 * Create an instance of {@link TabItem }
	 * 
	 */
	public TabItem createTabItem() {
		return new TabItem();
	}

	/**
	 * Create an instance of {@link Target }
	 * 
	 */
	public Target createTarget() {
		return new Target();
	}

	/**
	 * Create an instance of {@link Test }
	 * 
	 */
	public Test createTest() {
		return new Test();
	}

	/**
	 * Create an instance of {@link Test.Else }
	 * 
	 */
	public Test.Else createTestElse() {
		return new Test.Else();
	}

	/**
	 * Create an instance of {@link Test.If }
	 * 
	 */
	public Test.If createTestIf() {
		return new Test.If();
	}

	/**
	 * Create an instance of {@link Tokenizer }
	 * 
	 */
	public Tokenizer createTokenizer() {
		return new Tokenizer();
	}

	/**
	 * Create an instance of {@link Validator }
	 * 
	 */
	public Validator createValidator() {
		return new Validator();
	}

	/**
	 * Create an instance of {@link Viewer }
	 * 
	 */
	public Viewer createViewer() {
		return new Viewer();
	}

	/**
	 * Create an instance of {@link Viewer.InitialRows }
	 * 
	 */
	public Viewer.InitialRows createViewerInitialRows() {
		return new Viewer.InitialRows();
	}

	/**
	 * Create an instance of {@link Viewer.InitialRows.Row }
	 * 
	 */
	public Viewer.InitialRows.Row createViewerInitialRowsRow() {
		return new Viewer.InitialRows.Row();
	}

	/**
	 * Create an instance of {@link Widget }
	 * 
	 */
	public Widget createWidget() {
		return new Widget();
	}

}
