package com.headwire.aem.tooling.intellij.action;

import com.headwire.aem.tooling.intellij.communication.ServerConnectionManager;
import com.headwire.aem.tooling.intellij.config.ServerConfigurationManager;
import com.headwire.aem.tooling.intellij.explorer.SlingServerTreeSelectionHandler;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Created by schaefa on 6/13/15.
 */
public class RemoveServerConfigurationAction
    extends AbstractProjectAction
{

    public RemoveServerConfigurationAction() {
        super("remove.configuration.action");
    }

    @Override
    protected void execute(@NotNull Project project, @NotNull DataContext dataContext) {
        ServerConfigurationManager configurationManager = getConfigurationManager(project);
        SlingServerTreeSelectionHandler selectionHandler = getSelectionHandler(project);
        if(configurationManager != null && selectionHandler != null) {
            configurationManager.removeServerConfiguration(selectionHandler.getCurrentConfiguration());
        }
    }

    @Override
    protected boolean isEnabled(@NotNull Project project, @NotNull DataContext dataContext) {
        ServerConnectionManager connectionManager = getConnectionManager(project);
        return connectionManager != null && connectionManager.isConfigurationEditable();
    }
}
