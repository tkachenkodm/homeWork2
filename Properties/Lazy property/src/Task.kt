class LazyProperty(val initializer: () -> Int) {
    var field: Int? = null
    val lazy: Int
        get() {
            if(this.field == null){
                this.field = initializer()
            }
            return this.field!!

        }
}
