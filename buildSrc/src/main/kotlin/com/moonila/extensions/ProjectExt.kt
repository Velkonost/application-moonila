package com.moonila.extensions

import com.moonila.util.getApiProperty
import com.moonila.util.getKeystoreProperty
import com.moonila.util.getLocalProperty
import org.gradle.api.Project

/**
 * Obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getLocalProperty(propertyName: String): String {
    return getLocalProperty(propertyName, this)
}

/**
 * Obtain property declared on `$projectRoot/keystore.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getKeystoreProperty(propertyName: String): String {
    return getKeystoreProperty(propertyName, this)
}

/**
 * Obtain property declared on `$projectRoot/keystore.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getApiProperty(propertyName: String): String {
    return getApiProperty(propertyName, this)
}
