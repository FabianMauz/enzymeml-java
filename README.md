# Enzymeml-java-library
A library for handling the [Enzyme ML format 2.0](https://github.com/EnzymeML/enzymeml-specifications) in java. The library provides methods to de- and serialize data.
It supports the following data formats **json** and **xml**. 



###Validation###

To ensure a good data quality a validation of the structure of the data can be avtivated. The following issues are checked:
- The email of a creator is valid
- The IDs of elements are unique (excluding units)
- Referenced IDs are definied
- MeasurementData has a correct data amount (timepoints match datapoints, initial datapoint must equal the first point in data if present)


Thanks to the development team of Enzyme ML for their work and support.
