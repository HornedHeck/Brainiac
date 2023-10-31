package hornedheck.infrastructure

import KoinModules
import hornedheck.infrastructure.transcoding.TranscodingModule
import org.koin.core.module.Module
import org.koin.ksp.generated.module

class InfrastructureModules : KoinModules {

    override val modules: List<Module>
        get() = listOf(
            TranscodingModule().module
        )
}
