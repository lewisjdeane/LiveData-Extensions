package com.lewisdeane.livedataextensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations

/**
 * Instead of:
 *
 * Transformations.switchMap(liveA) { a ->
 *     // method(a)
 * }
 *
 * We can do:
 *
 * liveA.switchMap { a ->
 *     // method(a)
 * }
 */
fun <T, R> LiveData<T>.switchMap(
    transform: (T) -> LiveData<R>
): LiveData<R> = Transformations.switchMap(this) { transform(it) }

/**
 * Instead of:
 *
 * Transformations.map(liveA) { a ->
 *     // method(a)
 * }
 *
 * We can do:
 *
 * liveA.map { a ->
 *     // method(a)
 * }
 */
fun <T, R> LiveData<T>.map(
    transform: (T) -> R
): LiveData<R> = Transformations.map(this) { transform(it) }

/**
 * Instead of:
 *
 * Transformations.switchMap(liveA) { a ->
 *     Transformations.map(liveB) { b ->
 *         // method(a, b)
 *     }
 * }
 *
 * We can do:
 *
 * liveA.mapWith(liveB) { a, b ->
 *     // method(a, b)
 * }
 */
fun <T, A, R> LiveData<T>.mapWith(
    liveA: LiveData<A>,
    transform: (T, A) -> R
): LiveData<R> = Transformations.switchMap(this) { liveA.map(transform(it)) }

/**
 * Instead of:
 *
 * Transformations.switchMap(liveA) { a ->
 *     Transformations.switchMap(liveB) { b ->
 *         Transformations.map(liveC) { c ->
 *             // method(a, b, c)
 *         }
 *     }
 * }
 *
 * We can do:
 *
 * liveA.mapWith(liveB, liveC) { a, b, c ->
 *     // method(a, b, c)
 * }
 */
fun <T, A, B, R> LiveData<T>.mapWith(
    liveA: LiveData<A>,
    liveB: LiveData<B>,
    transform: (T, A, B) -> R
): LiveData<R> = Transformations.switchMap(this) { liveA.mapWith(liveB, transform(it)) }

/**
 * Instead of:
 *
 * Transformations.switchMap(liveA) { a ->
 *     Transformations.switchMap(liveB) { b ->
 *         Transformations.switchMap(liveC) { c ->
 *             Transformations.map(liveD) { d ->
 *                 // method(a, b, c, d)
 *             }
 *         }
 *     }
 * }
 *
 * We can do:
 *
 * liveA.mapWith(liveB, liveC, liveD) { a, b, c, d ->
 *     // method(a, b, c, d)
 * }
 */
fun <T, A, B, C, R> LiveData<T>.mapWith(
    liveA: LiveData<A>,
    liveB: LiveData<B>,
    liveC: LiveData<C>,
    transform: (T, A, B, C) -> R
): LiveData<R> = Transformations.switchMap(this) { liveA.mapWith(liveB, liveC, transform(it)) }

/**
 * Instead of:
 *
 * Transformations.switchMap(liveA) { a ->
 *     Transformations.switchMap(liveB) { b ->
 *         Transformations.switchMap(liveC) { c ->
 *             Transformations.switchMap(liveD) { d ->
 *                 Transformations.map(liveE) { e ->
 *                     // method(a, b, c, d, e)
 *                 }
 *             }
 *         }
 *     }
 * }
 *
 * We can do:
 *
 * liveA.mapWith(liveB, liveC, liveD, liveE) { a, b, c, d, e ->
 *     // method(a, b, c, d, e)
 * }
 */
fun <T, A, B, C, D, R> LiveData<T>.mapWith(
    liveA: LiveData<A>,
    liveB: LiveData<B>,
    liveC: LiveData<C>,
    liveD: LiveData<D>,
    transform: (T, A, B, C, D) -> R
): LiveData<R> =
    Transformations.switchMap(this) { liveA.mapWith(liveB, liveC, liveD, transform(it)) }

/**
 * Instead of:
 *
 * Transformations.switchMap(liveA) { a ->
 *     Transformations.switchMap(liveB) { b ->
 *         Transformations.switchMap(liveC) { c ->
 *             Transformations.switchMap(liveD) { d ->
 *                 Transformations.switchMap(liveE) { e ->
 *                     Transformations.map(liveF) { f ->
 *                         // method(a, b, c, d, e, f)
 *                     }
 *                 }
 *             }
 *         }
 *     }
 * }
 *
 * We can do:
 *
 * liveA.mapWith(liveB, liveC, liveD, liveE, liveF) { a, b, c, d, e, f ->
 *     // method(a, b, c, d, e, f)
 * }
 */
fun <T, A, B, C, D, E, R> LiveData<T>.mapWith(
    liveA: LiveData<A>,
    liveB: LiveData<B>,
    liveC: LiveData<C>,
    liveD: LiveData<D>,
    liveE: LiveData<E>,
    transform: (T, A, B, C, D, E) -> R
): LiveData<R> =
    Transformations.switchMap(this) { liveA.mapWith(liveB, liveC, liveD, liveE, transform(it)) }

/**
 * Override the `invoke` operator method in this file so that we can do partial application of
 * functions. We don't want to extend this to the entire codebase. We support partial application
 * of functions with up to 6 parameters.
 */
private operator fun <T, A, R, FUN : TwoParam<T, A, R>> FUN.invoke(t: T) =
    { a: A -> invoke(t, a) }

private operator fun <T, A, B, R, FUN : ThreeParam<T, A, B, R>> FUN.invoke(t: T) =
    { a: A, b: B -> invoke(t, a, b) }

private operator fun <T, A, B, C, R, FUN : FourParam<T, A, B, C, R>> FUN.invoke(t: T) =
    { a: A, b: B, c: C -> invoke(t, a, b, c) }

private operator fun <T, A, B, C, D, R, FUN : FiveParam<T, A, B, C, D, R>> FUN.invoke(t: T) =
    { a: A, b: B, c: C, d: D -> invoke(t, a, b, c, d) }

private operator fun <T, A, B, C, D, E, R, FUN : SixParam<T, A, B, C, D, E, R>> FUN.invoke(t: T) =
    { a: A, b: B, c: C, d: D, e: E -> invoke(t, a, b, c, d, e) }

/**
 * Aliases for methods taking n parameters and returning a single value.
 */
private typealias TwoParam<A, B, R> = (A, B) -> R
private typealias ThreeParam<A, B, C, R> = (A, B, C) -> R
private typealias FourParam<A, B, C, D, R> = (A, B, C, D) -> R
private typealias FiveParam<A, B, C, D, E, R> = (A, B, C, D, E) -> R
private typealias SixParam<A, B, C, D, E, F, R> = (A, B, C, D, E, F) -> R
