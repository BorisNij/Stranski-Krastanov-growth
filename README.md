# Integer Division Calculator

This project is an Integer Division Calculator implemented in Java. 
It demonstrates clean code principles and layered design, focusing on separation of concerns.
The application allows users to perform integer division and outputs detailed step-by-step solution.

## Features

- Perform integer division with detailed step-by-step calculations.
- Clean and modular code structure adhering to SOLID principles (an overkill for such a simple app, but fun nonetheless 😊)
- Extensive test suite using JUnit 5 parametrized tests.

## Design

![Flow chart](https://www.plantuml.com/plantuml/dsvg/ZPB1RiCW38RlF8LtIwJr1NAOEgsQr5CFMxKp2rwAH03Pfi-_qj6fKXgIKuZi__z-RBOicYIDJZt92KU4RvSmalMYT2-1uCX8AceIszkelS3U2mv8EtksR8D_ZR5M_WWkIVuYdMsFjTOtxVhaj0HQO_WUQDGYI4hbYB1vUP2i0tFvCUZDy_N4WTIqgsWhiJle2RNW7VmGaRGtt4m8hQgRPTpirI-aSiQAyrG7cnMN89H4_aR89I3av6GnySnqY-6CUlTvM3_j8kZWvxhOBokd_nKtIs-WLVEEXLVLtwXDgvPQbsRXWX_0_jN1b0RWOWCi6BdG10re1XQoVdWqgOmwSewthnkgBNgJHlSB)


![Class diagram](https://www.plantuml.com/plantuml/dsvg/hPJDYjmm3CVlVehqbcMsUO9bMMWeB6pPbXHwzjYQHE3OgIqFzADzzdgSrCcOpJP3vp1aehyY_IHBVd34BVbUiJVKGG_5NdaOB6fYGd7d2accUjG4BTWQZ-ZGwCOeJ-5PVtukVh2tHKF1loraa2LeUMvnniw6hzuGWgRPSa3hg1xzFdX5E2W8AceQfO-13hcgfzXFe5lgWiCJEhhBkGY6m7HVo8N1iLtAPMpFwGjIzpx-8x3bIcd9uORzObCd3dzjrRy-Ukm7jUpC4IoXuAg1WLjEouvqnk9te-bS51stnS2b32xDjtvlrFo5ytkoND0fCROwBwyStsvVVA2cszSwjwZMWJsYWBLQcr5EbMPkxxWINfsgAN1KPaiWVcMWX0LEi6Zfym2MQ-dA4tpuHSO9KgIWrIh0XBXR7Pdx50QMPhUMUqpT6mcgUY5So3NExt0-kfDLvhCU3pjjHeqj4jj5rnRoyIzlafGlJPHYgA1zMaOh8_NgEaVeR9Kpz2Jaz6durbYJckDEKAW9x84Bk62x0kZlQyzyujWqKf7WMkEKKczSkPZy_nVeWdxV_Qog2sy_jh6M67hxLSCsdKuCklLgO0-WfU_L7m00)


## Technologies Used

- Java 11
- Maven (with Maven Wrapper)
- JUnit 5
- Mockito


## Running the application
Replace or set the `dividend` and `divisor` variables with integer numbers in the following command:

### On Linux/MacOS

```shell
./mvnw clean compile exec:java -Dexec.args="$dividend $divisor"
```

### On Windows
From a CMD shell:

```shell
./mvnw.cmd clean compile exec:java -Dexec.args="$dividend $divisor"
```

## Running example
```shell
% export dividend=3567; export divisor=34 && ./mvnw clean compile exec:java -Dexec.args="$dividend $divisor"
[INFO] Scanning for projects...
[INFO] -----------------< net.bnijik.int-div-app:int-div-app >-----------------
[INFO] Building int-div-app 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
# <clipped>
[INFO] --- exec:3.0.0:java (default-cli) @ int-div-app ---
_3567|34
 34  |---
 --  |104
 _16
   0
  --
 _167
  136
  ---
   31
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.701 s
[INFO] ------------------------------------------------------------------------
```

## Testing

### On Linux/MacOS

```shell
./mvnw test
```

### On Windows

From a CMD shell:
```shell
./mvnw.cmd test
```