package software.shattered.corelib.api.feature

/**
 * Features that are enabled on a user-level.
 */
class CoreUserFeature(
    id: String,
    name: String,
    defaultEnabled: Boolean,
    description: String,
    permission: String
) : CoreFeature(id, name, defaultEnabled, description, permission)