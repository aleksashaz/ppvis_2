package UI;

import Selection_listeners.Add_players;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Window_control_family {

    Display display;
    public Window_control_family(Shell old_shell)
    {
        this.display=old_shell.getDisplay();
        old_shell.close();
        Shell shell=new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Button button1=new Button(shell,SWT.NONE);
        Button button2=new Button(shell,SWT.NONE);
        Button button3=new Button(shell,SWT.NONE);
        Button button4=new Button(shell,SWT.NONE);
        Button button5=new Button(shell,SWT.NONE);

        button1.setText("Удалить члена семьи");
        button2.setText("Добавить члена семьи");
        button3.setText("Редактировать члена семьи");
        button4.setText("Передать права");
        button5.setText("Создать ограничения");

        Font font_text=new Font(button1.getDisplay(),new FontData( "Arial", 18, SWT.BOLD ));
        button1.setFont(font_text);
        button2.setFont(font_text);
        button3.setFont(font_text);
        button4.setFont(font_text);
        button5.setFont(font_text);

        button1.addSelectionListener(new Delete_listener(shell));
        button2.addSelectionListener(new Add_players(shell));
        button3.addSelectionListener(new Refactor_listener(shell));
        button4.addSelectionListener(new Change_admin_listener(shell));



        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
    public void delete_family_member()
    {

    }

    public void refactor_family_member()
    {

    }

    public void give_rights()
    {

    }

    public void add_confines()
    {

    }

    public void create_family_member()
    {

    }
}
