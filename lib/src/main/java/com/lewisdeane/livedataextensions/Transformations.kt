package com.lewisdeane.livedataextensions

import androidx.lifecycle.LiveData

object Transformations {

    /**
     * Transformations.map(liveA) { a ->
     *     // method(a)
     * }
     */
    fun <A, R> map(
        liveA: LiveData<A>,
        transform: (A) -> R
    ): LiveData<R> = liveA.map(transform)

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
     * Transformations.map(liveA, liveB) { a, b ->
     *     // method(a, b)
     * }
     */
    fun <A, B, R> map(
        liveA: LiveData<A>,
        liveB: LiveData<B>,
        transform: (A, B) -> R
    ): LiveData<R> = liveA.mapWith(liveB, transform)

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
     * Transformations.map(liveA, liveB, liveC) { a, b, c ->
     *     // method(a, b, c)
     * }
     */
    fun <A, B, C, R> map(
        liveA: LiveData<A>,
        liveB: LiveData<B>,
        liveC: LiveData<C>,
        transform: (A, B, C) -> R
    ): LiveData<R> = liveA.mapWith(liveB, liveC, transform)

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
     * Transformations.map(liveA, liveB, liveC, liveD) { a, b, c, d ->
     *     // method(a, b, c, d)
     * }
     */
    fun <A, B, C, D, R> map(
        liveA: LiveData<A>,
        liveB: LiveData<B>,
        liveC: LiveData<C>,
        liveD: LiveData<D>,
        transform: (A, B, C, D) -> R
    ): LiveData<R> = liveA.mapWith(liveB, liveC, liveD, transform)

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
     * Transformations.map(liveA, liveB, liveC, liveD, liveE) { a, b, c, d, e ->
     *     // method(a, b, c, d, e)
     * }
     */
    fun <A, B, C, D, E, R> map(
        liveA: LiveData<A>,
        liveB: LiveData<B>,
        liveC: LiveData<C>,
        liveD: LiveData<D>,
        liveE: LiveData<E>,
        transform: (A, B, C, D, E) -> R
    ): LiveData<R> = liveA.mapWith(liveB, liveC, liveD, liveE, transform)

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
     * Transformations.map(liveA, liveB, liveC, liveD, liveE, liveF) { a, b, c, d, e, f ->
     *     // method(a, b, c, d, e, f)
     * }
     */
    fun <A, B, C, D, E, F, R> map(
        liveA: LiveData<A>,
        liveB: LiveData<B>,
        liveC: LiveData<C>,
        liveD: LiveData<D>,
        liveE: LiveData<E>,
        liveF: LiveData<F>,
        transform: (A, B, C, D, E, F) -> R
    ): LiveData<R> = liveA.mapWith(liveB, liveC, liveD, liveE, liveF, transform)
}
