package software.shattered.corelib.api.feature

/**
 * Features that are enabled in specific parts of a world.
 */
class CoreRegionFeature(
    id: String,
    name: String,
    defaultEnabled: Boolean,
    description: String,
    permission: String
) : CoreFeature(id, name, defaultEnabled, description, permission)