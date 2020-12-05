import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int){}

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR;


}

class MultipleIntervals (val timeInterval: TimeInterval, val number: Int){

}

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate =
        addTimeIntervals(timeInterval, 1)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}

private operator fun TimeInterval.times(i: Int): MultipleIntervals =
        MultipleIntervals(this, i)


private operator fun MyDate.plus(multipleIntervals: MultipleIntervals): MyDate =
        addTimeIntervals(multipleIntervals.timeInterval, multipleIntervals.number)
