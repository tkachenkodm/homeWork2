import java.util.*

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(collection1: C, collection2: C, predicate: (T)-> Boolean) : Pair<C, C>{
    for (item in this) {
        if (predicate(item)) {
            collection1.add(item)
        } else {
            collection2.add(item)
        }
    }
    return collection1 to collection2
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}



fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}


