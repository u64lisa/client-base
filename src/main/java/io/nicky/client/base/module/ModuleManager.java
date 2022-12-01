package io.nicky.client.base.module;

import io.nicky.client.base.event.EventBus;
import io.nicky.client.base.module.settings.SettingsManager;

import java.util.ArrayList;
import java.util.List;

public final class ModuleManager {

    final List<Module> moduleList = new ArrayList<>();

    private final SettingsManager settingsManager;

    private final EventBus eventBus;

    public ModuleManager(EventBus eventBus) {
        this.eventBus = eventBus;

        this.settingsManager = new SettingsManager();
        
    }

    public void registerNamed(final Module module, final ModuleDescriptor descriptor) {

    }

    public SettingsManager getSettingsManager() {
        return settingsManager;
    }

    public EventBus getEventBus() {
        return eventBus;
    }
}
