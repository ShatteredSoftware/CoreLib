package software.shattered.corelib.api.i18n

import com.google.inject.Singleton
import com.squareup.moshi.Moshi
import dev.misfitlabs.kotlinguice4.KotlinModule
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.Template
import software.shattered.corelib.api.attribute.Reloadable
import java.io.File

@Singleton
class CoreI18n(
    private val langFile: File,
    moshi: Moshi,
    private val miniMessage: MiniMessage): KotlinModule(), Reloadable {
    private var messageMap: Map<String, String>

    private val adapter = moshi.adapter<Map<String, String>>(Map::class.java)

    init {
        val contents = langFile.readLines().joinToString("\n")
        messageMap = adapter.fromJson(contents) ?: mapOf()
    }

    fun get(id: String, args: Map<String, String>): Component {
        val message = messageMap[id] ?: ""
        return miniMessage.parse(message, args.entries.map { (key: String, value: String) ->
            Template.of(key, value)
        })
    }

    override fun reload() {
        val contents = langFile.readLines().joinToString("\n")
        messageMap = adapter.fromJson(contents) ?: mapOf()
    }
}