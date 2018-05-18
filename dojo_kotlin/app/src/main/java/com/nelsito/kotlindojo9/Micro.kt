package com.nelsito.kotlindojo9

/**
 * Created by npuglisi on 12/12/17.
 */
class Micro : Transporte {
    constructor() : super(Precio(2.1625))
    constructor(precio: Precio) : super(precio)
}
