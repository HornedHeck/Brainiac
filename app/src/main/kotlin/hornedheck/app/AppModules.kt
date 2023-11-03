package hornedheck.app

import KoinModules
import org.koin.core.module.Module
import org.koin.ksp.generated.defaultModule

class AppModules : KoinModules {

    override val modules: List<Module>
        get() = listOf(defaultModule)
}
