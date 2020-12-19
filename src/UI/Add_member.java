package UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Game {
    Display display;
    public Game(Shell old_shell)
    {
        display=old_shell.getDisplay();
        old_shell.close();
        Shell shell= new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Label title =new Label(shell,SWT.NONE);
        Font font_text=new Font(title.getDisplay(),new FontData( "Arial", 20, SWT.BOLD ));
        title.setFont(font_text);
        title.setText("Начать игру");

        RowData data =new RowData(200,20);



        Label label1 =new Label(shell,SWT.NONE);
        label1.setText("Ник");
        Text text1 = new Text(shell,SWT.NONE);
        text1.setLayoutData(data);

        Label label2 =new Label(shell,SWT.NONE);
        label2.setText("Прозвище");
        Text text2 = new Text(shell,SWT.NONE);
        text2.setLayoutData(data);

        Label label3 =new Label(shell,SWT.NONE);
        label3.setText("Опыт");
        Text text3 = new Text(shell,SWT.NONE);
        text3.setLayoutData(data);

        Button button =new Button(shell,SWT.NONE);
        button.setLayoutData(data);
        button.setText("Добавить");

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
