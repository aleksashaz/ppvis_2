package UI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Window_load_media {

    Display display;
    public Window_load_media(Shell old_shell)
    {

        display = old_shell.getDisplay();
        old_shell.close();
        Shell shell= new Shell(display);
        shell.setLayout(new RowLayout(SWT.VERTICAL));


        Label label = new Label(shell,SWT.NONE);

        Font font_text=new Font(label.getDisplay(),new FontData( "Arial", 18, SWT.BOLD ));
        label.setText("Имя файла");
        label.setFont(font_text);

        RowData data =new RowData(400,40);

        Text text = new Text(shell,SWT.NONE);
        text.setLayoutData(data);

        Label label2 = new Label(shell,SWT.NONE);
        label2.setFont(font_text);
        label2.setText("Тип файла");


        Group radio_button_group = new Group(shell,SWT.VERTICAL);
        radio_button_group.setLayout(new RowLayout(SWT.VERTICAL));
        Button button_type_one = new Button(radio_button_group,SWT.RADIO);
        Button button_type_two = new Button(radio_button_group,SWT.RADIO);
        Button button_type_three = new Button(radio_button_group,SWT.RADIO);

        button_type_one.setText("Музыка");
        button_type_two.setText("Картинка");
        button_type_three.setText("Фильм");

        Label label3 = new Label(shell,SWT.NONE);
        label3.setFont(font_text);
        label3.setText("Путь к файлу");
        Text text1 = new Text(shell,SWT.NONE);
        text1.setLayoutData(data);

        Label label4 = new Label(shell,SWT.NONE);
        label4.setFont(font_text);
        label4.setText("Оценки");

        Group radio_button_group2 = new Group(shell,SWT.VERTICAL);
        radio_button_group2.setLayout(new RowLayout(SWT.VERTICAL));
        Button button_mark1 = new Button(radio_button_group2,SWT.RADIO);
        Button button_mark2 = new Button(radio_button_group2,SWT.RADIO);
        Button button_mark3 = new Button(radio_button_group2,SWT.RADIO);
        Button button_mark4 = new Button(radio_button_group2,SWT.RADIO);
        Button button_mark5 = new Button(radio_button_group2,SWT.RADIO);

        button_mark1.setText("1");
        button_mark2.setText("2");
        button_mark3.setText("3");
        button_mark4.setText("4");
        button_mark5.setText("5");

        Label label5 = new Label(shell,SWT.NONE);
        label5.setFont(font_text);
        label5.setText("Коментарии");

        RowData data1 =new RowData(400,400);
        Text text2 = new Text(shell,SWT.NONE);
        text2.setLayoutData(data1);

        Button load =new Button(shell,SWT.NONE);
        load.setFont(font_text);
        load.setText("Загрузить");


        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
    public void add_mark()
    {

    }

    public void add_media()
    {

    }

    public void load_media()
    {

    }
}
