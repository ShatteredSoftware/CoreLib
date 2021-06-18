package software.shattered.corelib.api.feature

class CoreWorldFeature(
    id: String,
    name: String,
    defaultEnabled: Boolean,
    description: String,
    permission: String
) : CoreFeature(id, name, defaultEnabled, description, permission)