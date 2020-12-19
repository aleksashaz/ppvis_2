package Selection_listeners;

import UI.Window_control_catalog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

public class Add_players extends SelectionAdapter {
    Shell shell;
    public Add_players(Shell shell)
    {
        this.shell=shell;
    }

    public Add_players() {

    }

    public void widgetSelected(SelectionEvent event) {
        Add_players window = new Add_players(shell);
    }
}
