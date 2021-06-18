package software.shattered.corelib.api.feature

/**
 * Features that are enabled on a server-level.
 */
class CoreServerFeature(
    id: String,
    name: String,
    defaultEnabled: Boolean,
    description: String,
    permission: String
) : CoreFeature(id, name, defaultEnabled, description, permission)