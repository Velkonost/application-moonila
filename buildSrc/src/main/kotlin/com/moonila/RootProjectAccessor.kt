package com.moonila

import org.gradle.api.internal.catalog.DelegatingProjectDependency

typealias RootProjectAccessor = String

fun RootProjectAccessor.join(vararg other: DelegatingProjectDependency): RootProjectAccessor {
    var accessor = this
    other.forEach {
        accessor = accessor.plus(".${it.name}")
    }
    return accessor
}

private const val ROOT_PACKAGE: RootProjectAccessor = "com.moonila"
const val ANDROID_PACKAGE: RootProjectAccessor = ROOT_PACKAGE