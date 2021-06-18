package software.shattered.corelib.api.attribute

import software.shattered.corelib.api.feature.CoreFeature

interface FeatureUser {
    fun canUseFeature(feature: CoreFeature): Boolean
}
