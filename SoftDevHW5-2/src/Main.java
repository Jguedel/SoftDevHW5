/*
 * @author jguedel
 * @version 1.0
 * 
 */
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Composite {
	
	/** The file name. */
	private Text fileName;
	
	/** The Mean. */
	private Text Mean;
	
	/** The sd. */
	private Text SD;
	
	/** The selected file. */
	private File selectedFile;

	/**
	 * Create the composite.
	 *
	 * @param args the arguments
	 */

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, false));
		Main linkList = new Main(shell, SWT.NONE);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();

		}
		display.dispose();
	}

	/**
	 * Instantiates a new main.
	 *
	 * @param parent the parent
	 * @param style  the style
	 */
	public Main(Composite parent, int style) {
		super(parent, style);
		setLayout(null);

		Label lblMeanAndStandard = new Label(this, SWT.NONE);
		lblMeanAndStandard.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 16, SWT.BOLD));
		lblMeanAndStandard.setBounds(82, 10, 293, 30);
		lblMeanAndStandard.setText("Mean and standard deviation ");

		Button btnGetFileOf = new Button(this, SWT.NONE);
		btnGetFileOf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnValue = jfc.showOpenDialog(null);
				// int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = jfc.getSelectedFile();
					//System.out.println(selectedFile.getAbsolutePath());
					fileName.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		btnGetFileOf.setBounds(155, 56, 131, 21);
		btnGetFileOf.setText("Get file of Numbers");

		fileName = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		fileName.setTouchEnabled(true);
		fileName.setText("File Name");
		fileName.setBounds(82, 101, 288, 19);

		Label lblMean = new Label(this, SWT.NONE);
		lblMean.setBounds(58, 201, 56, 16);
		lblMean.setText("Mean");

		Label lblStandardDeviation = new Label(this, SWT.NONE);
		lblStandardDeviation.setBounds(4, 239, 110, 16);
		lblStandardDeviation.setText("Standard deviation ");

		Mean = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		Mean.setTouchEnabled(true);
		Mean.setBounds(114, 201, 273, 19);

		SD = new Text(this, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP);
		SD.setTouchEnabled(true);
		SD.setBounds(114, 239, 261, 19);

		Button btnCalculate = new Button(this, SWT.NONE);
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				try {
					Calc.calc(selectedFile);
					Mean.setText(String.valueOf(Calc.getMean()));
					SD.setText(String.valueOf(Calc.getSD()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCalculate.setBounds(184, 154, 70, 21);
		btnCalculate.setText("Calculate");

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.widgets.Composite#checkSubclass()
	 */
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
