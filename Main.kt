fun main() {
//    val matrix = createMatrix(3,4)
//    println(matrix.joinToString("\n") { it.contentToString() })
//    println("---")
//    println(f491(matrix).joinToString("\n") { it.contentToString() })
//    println("---")
//    println(f492(matrix).joinToString("\n") { it.contentToString() })
//    println("---")
//    println(f493(matrix).joinToString("\n") { it.contentToString() })
//    println("---")
//------------------------------------------------------------------------------
//    val n = 3
//    val matrix2 = createMatrix(n, 2*n)
//    println(matrix2.joinToString("\n") { it.contentToString() })
//    println("---")
//    println(f494(matrix2).joinToString("\n") { it.contentToString() })
//    println("---")
//    println(f495(matrix2).joinToString("\n") { it.contentToString() })
//    println("---")
//    println(f496(matrix2).joinToString("\n") { it.contentToString() })
//    println("---")
//--------------------------------------------------------------------------------
    val n = 3
    val matrix3 = createMatrix(n,n)
    println(matrix3.joinToString("\n") { it.contentToString() })
    println("---")
//    println(f497(matrix3).joinToString("\n") { it.contentToString() })
//    println("---")
//    println(f498(matrix3).joinToString("\n") { it.contentToString() })
//    println("---")
//    f499(matrix3)
//    println("---")
//    println(f500(matrix3))
//    println("---")
//    println(f501(matrix3))
//    println("---")
//    println(f502(matrix3))
//    println("---")
//    println(f503(matrix3))
//    println("---")
    println(f504(matrix3))
    println("---")
}
fun createMatrix(line: Int, row: Int): Array<Array<Int>> {
    val numbers = (10..99).toList().shuffled()
    val matrix = Array(line) { i ->
        Array(row) { j ->
            numbers[i * row + j]
        }
    }
    return matrix
}
fun f504(matrix: Array<Array<Int>>): List<Int> {
    val rowSums = mutableListOf<Int>()

    for (i in matrix.indices) {
        val row = matrix[i]
        val diagonalElement = row[i]
        var sum = 0

        for (j in row.indices) {
            val element = row[j]
            if (element % 2 == 1 && (i + j) % 2 == 1 && element > diagonalElement) {
                sum += element
            }
        }

        rowSums.add(if (sum > 0) sum else 0)
    }

    return rowSums
}
fun f503(matrix: Array<Array<Int>>): List<Int> {
    val minEvenElements = mutableListOf<Int>()

    for (row in matrix) {
        var minEven = Int.MAX_VALUE

        for (element in row) {
            if (element % 2 == 0 && element < minEven) {
                minEven = element
            }
        }

        if (minEven != Int.MAX_VALUE) {
            minEvenElements.add(minEven)
        }
    }

    return minEvenElements
}
fun f502(matrix: Array<Array<Int>>): List<Int> {
    val maxOddElements = mutableListOf<Int>()

    for (row in matrix) {
        var maxOdd = Int.MIN_VALUE

        for (element in row) {
            if (element % 2 != 0 && element > maxOdd) {
                maxOdd = element
            }
        }

        if (maxOdd != Int.MIN_VALUE) {
            maxOddElements.add(maxOdd)
        }
    }

    return maxOddElements
}
fun f501(matrix: Array<Array<Int>>): List<Int> {
    val rowSums = mutableListOf<Int>()

    for (i in matrix.indices) {
        val row = matrix[i]
        val diagonalElement = row[i]
        var mul = 1

        for (j in row.indices) {
            val element = row[j]
            if (element % 2 == 0 && (i + j) % 2 == 1 && element < diagonalElement) {
                mul *= element
            }
        }

        rowSums.add(if (mul > 0) mul else 1)
    }

    return rowSums
}
fun f500(matrix: Array<Array<Int>>): Double {
    var sum = 0.0
    var count = 0
    for (row in matrix) {
        if (row.isNotEmpty()) {
            sum += (row.min() * row.max())
            count++
        }
    }
    return if (count > 0) sum / count else 0.0
}
fun f499(matrix: Array<Array<Int>>) {
    val element = (matrix.findMinElement()+matrix.findMaxElement())/2
    val matrixList = matrix.flatten()

    for (i in matrixList.indices) {
        for (j in i + 1 until matrixList.size) {
            val sum = matrixList[i] + matrixList[j]
            if (sum > element && sum % 2 == 0) {
                println("Pair (${matrixList[i]}, ${matrixList[j]}) has a sum greater than $element")
            }
        }
    }
}
fun f498(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val numRows = matrix.size

    for (i in 0 until numRows) {
        val minRow = matrix[i]
        val minColIndex = minRow.indices.minByOrNull { minRow[it] } ?: continue
        if (minColIndex != numRows - 1 - i) {
            val temp = matrix[i][minColIndex]
            matrix[i][minColIndex] = matrix[numRows - 1 - i][numRows - 1 - i]
            matrix[numRows - 1 - i][numRows - 1 - i] = temp
        }
    }

    return matrix
}
fun f497(matrix: Array<Array<Int>>): Array<Array<Int>> {
    for (i in matrix.indices) {
        val maxRow = matrix[i]
        val maxColIndex = maxRow.indices.maxByOrNull { maxRow[it] } ?: continue
        if (maxColIndex != i) {
            val temp = matrix[i][maxColIndex]
            matrix[i][maxColIndex] = matrix[i][i]
            matrix[i][i] = temp
        }
    }

    return matrix
}
fun f496(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val numRows = matrix.size
    val numCols = matrix[0].size

    val diagonalIndices = (0 until numRows).map { it to it }

    val sortedIndices = diagonalIndices.sortedBy { matrix[it.first][it.second] }

    val newMatrix = Array(numRows) { Array(numCols) { 0 } }
    for (i in sortedIndices.indices) {
        val oldIndex = sortedIndices[i].first
        newMatrix[i] = matrix[oldIndex]
    }

    return newMatrix
}
fun f495(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val numRows = matrix.size
    val numCols = matrix[0].size

    val lastElementIndices = matrix.mapIndexedNotNull { index, row ->
        if (row.isNotEmpty()) index to row.lastIndex else null
    }

    val sortedIndices = lastElementIndices.sortedBy { matrix[it.first][it.second] }

    val newMatrix = Array(numRows) { Array(numCols) { 0 } }
    for (i in sortedIndices.indices) {
        val oldIndex = sortedIndices[i].first
        newMatrix[i] = matrix[oldIndex]
    }

    return newMatrix
}
fun f494(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val numRows = matrix.size
    val numCols = matrix[0].size

    val firstElementIndices = matrix.mapIndexedNotNull { index, row ->
        if (row.isNotEmpty()) index else null
    }

    val sortedIndices = firstElementIndices.sortedBy { matrix[it][0] }

    val newMatrix = Array(numRows) { Array(numCols) { 0 } }
    for (i in sortedIndices.indices) {
        val oldIndex = sortedIndices[i]
        newMatrix[i] = matrix[oldIndex]
    }

    return newMatrix
}
fun f493(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val max = matrix.findMaxElement()

    val maxIndices = matrix.findElementIndices(max)
    val (maxRowIndex, maxColIndex) = maxIndices

    return matrix.createMatrixWithoutRowAndColumn(maxRowIndex,maxColIndex)
}
fun f492(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val min = matrix.findMinElement()
    val max = matrix.findMaxElement()

    val minIndices = matrix.findElementIndices(min)
    val maxIndices = matrix.findElementIndices(max)

    val (minRowIndex, minColIndex) = minIndices
    val (maxRowIndex, maxColIndex) = maxIndices

    matrix.swapRow(minRowIndex,maxRowIndex)
    matrix.swapColumn(minColIndex,maxColIndex)

    return matrix
}

fun Array<Array<Int>>.findElementIndices(element: Int): Pair<Int, Int> {
    for (i in indices) {
        for (j in this[i].indices) {
            if (this[i][j] == element) {
                return i to j
            }
        }
    }
    return -1 to -1
}
fun f491(matrix: Array<Array<Int>>): Array<Array<Int>> {
    val element = matrix.findMaxElement()

    val maxIndices = matrix.findElementIndices(element)
    val (maxRowIndex, maxColIndex) = maxIndices

    matrix.swapRow(0,maxRowIndex)
    matrix.swapColumn(0,maxColIndex)
    return matrix
}
fun Array<Array<Int>>.findMaxElement(): Int {
    var maxElement = Int.MIN_VALUE
    for (row in this) {
        for (element in row) {
            if (element > maxElement) {
                maxElement = element
            }
        }
    }
    return maxElement
}
fun Array<Array<Int>>.swapRow(row1: Int, row2: Int) {
    val temp = this[row1]
    this[row1] = this[row2]
    this[row2] = temp
}
fun Array<Array<Int>>.swapColumn(col1: Int, col2: Int) {
    for (i in indices) {
        val temp = this[i][col1]
        this[i][col1] = this[i][col2]
        this[i][col2] = temp
    }
}
fun Array<Array<Int>>.findMinElement(): Int {
    var minElement = Int.MAX_VALUE
    for (row in this) {
        for (element in row) {
            if (element < minElement) {
                minElement = element
            }
        }
    }
    return minElement
}
fun Array<Array<Int>>.createMatrixWithoutRowAndColumn(row: Int, col: Int): Array<Array<Int>> {
    val numRows = size
    val numCols = get(0).size

    val newMatrix = Array(numRows - 1) { Array(numCols - 1) { 0 } }

    var newRow = 0
    for (i in indices) {
        if (i == row) continue

        var newCol = 0
        for (j in this[i].indices) {
            if (j == col) continue

            newMatrix[newRow][newCol] = this[i][j]
            newCol++
        }
        newRow++
    }
    return newMatrix
}