
import Selection_listeners.Add_players;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class UI {
    private Game controller;
    UI (Game controller)
    {
        this.controller=controller;
    }
    public void open_window()
    {
        Shell shell;
        Display display = new Display();
        shell = new Shell(display);
        shell.setLayout(new RowLayout(SWT.HORIZONTAL));

        Composite text_composite=new Composite(shell,SWT.NONE);
        text_composite.setLayout(new RowLayout(SWT.VERTICAL));

        Label Lable=new Label(text_composite,SWT.NONE);
        Label Error_lable=new Label(text_composite,SWT.NONE);
        Lable.setText("Играть");

        Font font=new Font(Lable.getDisplay(),new FontData( "Arial", 14, SWT.BOLD ));
        Font font_text=new Font(Lable.getDisplay(),new FontData( "Arial", 18, SWT.BOLD ));
        Lable.setFont(font);

        Text login = new Text(text_composite, SWT.NONE);
        Text password = new Text(text_composite, SWT.NONE);
        login.setFont(font_text);
        password.setFont(font_text);
        Button button = new Button(text_composite,SWT.NONE);
        button.setText("Добавить");
        button.addSelectionListener(new Add_players() );

        RowData data =new RowData(400,40);

        login.setLayoutData(data);
        password.setLayoutData(data);
        Lable.setLayoutData(data);


        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
    public void close_window()
    {

    }
}
