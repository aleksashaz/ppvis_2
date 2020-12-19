package UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Delete_member {
    Display display;
    public Delete_member(Shell old_shell)
    {
        display=old_shell.getDisplay();
        old_shell.close();
        Shell shell= new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Label title =new Label(shell,SWT.NONE);
        Font font_text=new Font(title.getDisplay(),new FontData( "Arial", 20, SWT.BOLD ));
        title.setFont(font_text);
        title.setText("Удаление пользователя");

        Label label =new Label(shell,SWT.NONE);
        label.setText("Член семьи");

        RowData data =new RowData(400,40);
        Text text = new Text(shell,SWT.NONE);
        text.setFont(font_text);
        text.setLayoutData(data);

        Button button = new Button(shell,SWT.NONE);
        button.setFont(font_text);
        button.setText("Удалить");

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}
