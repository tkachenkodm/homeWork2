fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            var row = 1
            products.forEach {
                tr {
                    td(getCellColor(0, row)) {
                        text(it.description)
                    }
                    td(getCellColor(1, row)) {
                        text(it.price)
                    }
                    td(getCellColor(2, row)) {
                        text(it.popularity)
                    }
                }
                row++
            }
        }
    }.toString()
}

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) % 2 == 0) "#dce4ff" else "#eff2ff"
