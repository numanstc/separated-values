## Separated Values Create Demo

#### What is this?
This is an example for Test-Driven Development (TDD). There are various approaches to generating separated values, with two methods available for creating a string of separated values.
#### Table Style Values
This approach involves a fixed 2-dimensional array. By utilizing this array, you can incrementally add values. 
An example is provided below:
```java
TableStyleValues sut = new TableStyleValues(2, 2);
sut.setSeparator(Separator.SEMICOLON);

sut.put(Point.create(1, 1), "Row 1, Col 1");
sut.put(Point.create(1, 2), "Row 1, Col 2");
sut.put(Point.create(2, 1), "Row 2, Col 1");
sut.put(Point.create(2, 2), "Row 2, Col 2");

assertEquals(
"""
    Row 1, Col 1;Row 1, Col 2
    Row 2, Col 1;Row 2, Col 2""",
sut.create()
);
```

#### String Style Values
This approach incorporates a StringBuilder that functions similarly to a builder. Variables will be added to this builder. Additionally, this approach will verify the lengths of columns and rows.
Here is an example below:
```java
assertEquals(
    """
        Row 1, Col 1;Row 1, Col 2;Row 1, Col 3
        ;;
        ;;
        Row 4, Col 1;Row 4, Col 2;Row 4, Col 3""",
    StringStyleValues
        .builder(Separator.SEMICOLON)
        .addRow()
        .addCol("Row 1, Col 1")
        .addCol("Row 1, Col 2")
        .addCol("Row 1, Col 3")
        .addRow()
        .addRow()
        .addRow()
        .addCol("Row 4, Col 1")
        .addCol("Row 4, Col 2")
        .addCol("Row 4, Col 3")
        .create()
);
```
