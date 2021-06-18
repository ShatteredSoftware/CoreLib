package software.shattered.corelib.api

import com.squareup.moshi.Moshi
import dev.misfitlabs.kotlinguice4.KotlinModule
import net.kyori.adventure.text.minimessage.MiniMessage
import software.shattered.corelib.api.feature.CoreFeatureManager
import software.shattered.corelib.api.i18n.CoreI18n
import software.shattered.corelib.api.player.CorePlayerManager
import software.shattered.corelib.api.region.CoreRegionManager
import software.shattered.corelib.api.world.CoreWorldManager
import software.shattered.corelib.plugin.CoreLibPlugin
import software.shattered.corelib.plugin.PluginConfig

/**
 * The primary module for the plugin.
 *
 * @param plugin The plugin implementation for the current server software.
 * @param pluginConfig The config for the current implementation.
 *
 * @author UberPilot
 * @since 1.0
 */
class CoreLibModule(private val plugin: CoreLibPlugin,
                    private val pluginConfig: PluginConfig): KotlinModule() {

    private val moshi: Moshi = Moshi.Builder().build()
    private val miniMessage: MiniMessage = MiniMessage.builder().build()

    private val playerManager = CorePlayerManager()
    private val worldManager = CoreWorldManager()
    private val regionManager = CoreRegionManager()
    private val featureManager = CoreFeatureManager()
    private val i18n = CoreI18n(pluginConfig.langFile, moshi, miniMessage)

    override fun configure() {
        // External instances
        bind<Moshi>().toInstance(moshi)
        bind<MiniMessage>().toInstance(miniMessage)

        // Core managers
        bind<CoreI18n>().toInstance(i18n)
        bind<CoreLibPlugin>().toInstance(plugin)
        bind<CorePlayerManager>().toInstance(playerManager)
        bind<CoreWorldManager>().toInstance(worldManager)
        bind<CoreRegionManager>().toInstance(regionManager)
        bind<CoreFeatureManager>().toInstance(featureManager)
    }
}