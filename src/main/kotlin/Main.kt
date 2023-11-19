import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.Path
import java.net.URL
import java.nio.file.Paths

fun checkPath(path: String? = null): Boolean {
    return !(path == null || !Files.exists(Path(path)))
}

fun download(path: String? = null) {
    val loc: String = if (checkPath(path)) path.toString() else "/home/${System.getProperty("user.name")}/.local/getcord"
    val remote = URL("https://discord.com/api/download?platform=linux&format=tar.gz")

    remote.openStream().use {
        Files.copy(it, Paths.get("${loc}/discord.tar.gz"))
    }
}

fun main() {
    download()
}