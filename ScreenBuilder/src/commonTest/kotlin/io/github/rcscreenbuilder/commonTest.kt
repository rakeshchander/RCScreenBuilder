package io.github.rcscreenbuilder

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        val contents = AppBuilder.initialize(jsonContents)

        println(contents)


    }
}

val jsonContents = """
            {
  "features": [
    {
      "id": "heart_risk",
      "title": "Heart Risk Calculation",
      "target": "api/calculate_heart_disease",
      "screen": "heart_risk_input"
    },
    {
      "id": "cardio_vascular_risk",
      "title": "Cardio Vascular Risk Calculation",
      "target": "api/calculate_cardio_disease",
      "screen": "cardio_risk_input"
    }
  ],
  "screens": {
    "heart_risk_input": [
      {
        "type": "Text",
        "title": "Enter Age",
        "keyName": "age",
        "keyboardType": "Number",
        "regex": "[0-9]+"
      },
      {
        "type": "DropDown",
        "title": "Sex M/F",
        "keyName": "sex",
        "options": [
          {
            "displayValue": "Male",
            "hashId": "0"
          },
          {
            "displayValue": "Female",
            "hashId": "1"
          }
        ],
        "isMandatory": true
      },
      {
        "type": "DropDown",
        "title": "Chest pain type",
        "keyName": "cp",
        "options": [
          {
            "displayValue": "Typical angina",
            "hashId": "0"
          },
          {
            "displayValue": "Atypical angina",
            "hashId": "1"
          },
          {
            "displayValue": "Non-anginal pain",
            "hashId": "2"
          },
          {
            "displayValue": "Asymptomatic",
            "hashId": "3"
          }
        ],
        "isMandatory": true
      },
      {
        "type": "Text",
        "title": "Enter resting BP",
        "keyName": "trestbps",
        "keyboardType": "Number"
      },
      {
        "type": "Text",
        "title": "Serum cholesterol",
        "keyName": "chol",
        "keyboardType": "Number",
        "regex": "[0-9]+"
      },
      {
        "type": "Checkbox",
        "value": false,
        "title": "Did your fasting blood sugar > 120 mg/dl",
        "keyName": "fbs",
        "regex": "[0-9]+"
      },
      {
        "type": "DropDown",
        "title": "Resting ECG type",
        "keyName": "restecg",
        "options": [
          {
            "displayValue": "Normal",
            "hashId": "0"
          },
          {
            "displayValue": "Having ST-T wave abnormality (T wave inversions and/or ST elevation or depression of > 0.05 mV)",
            "hashId": "1"
          },
          {
            "displayValue": "Showing probable or definite left ventricular hypertrophy by Estes' criteria",
            "hashId": "2"
          }
        ],
        "isMandatory": true
      },
      {
        "type": "Text",
        "title": "Max Heart Rate",
        "keyName": "thalach",
        "keyboardType": "Number",
        "regex": "[0-9]+"
      },
      {
        "type": "Checkbox",
        "value": false,
        "title": "Enter the exercise induces angina?",
        "keyName": "exang",
        "regex": "[0-9]+"
      },
      {
        "type": "Text",
        "title": "Enter ST depression induced by exercise relative to rest",
        "keyName": "oldpeak",
        "keyboardType": "Decimal",
        "regex": "[0-9.]+"
      },
      {
        "type": "DropDown",
        "title": "Enter the the slope of the peak exercise ST segment",
        "keyName": "slope",
        "options": [
          {
            "displayValue": "Upsloping",
            "hashId": "0"
          },
          {
            "displayValue": "Flat",
            "hashId": "1"
          },
          {
            "displayValue": "Downsloping",
            "hashId": "2"
          }
        ],
        "isMandatory": true
      },
      {
        "type": "DropDown",
        "title": "Major vessels colored by fluoroscopy",
        "keyName": "ca",
        "options": [
          {
            "displayValue": "0",
            "hashId": "0"
          },
          {
            "displayValue": "1",
            "hashId": "1"
          },
          {
            "displayValue": "2",
            "hashId": "2"
          },
          {
            "displayValue": "3",
            "hashId": "3"
          }
        ],
        "isMandatory": true
      },
      {
        "type": "DropDown",
        "title": "Thalassemia",
        "keyName": "thal",
        "options": [
          {
            "displayValue": "Normal",
            "hashId": "0"
          },
          {
            "displayValue": "Fixed defect",
            "hashId": "1"
          },
          {
            "displayValue": "Reversable defect",
            "hashId": "2"
          }
        ],
        "isMandatory": true
      }
    ],
    "cardio_risk_input": [
      {
        "type": "Text",
        "title": "Enter Age",
        "keyName": "age",
        "keyboardType": "Number",
        "regex": "[0-9]+"
      },
      {
        "type": "DropDown",
        "title": "Sex M/F",
        "keyName": "sex",
        "options": [
          {
            "displayValue": "Male",
            "hashId": "0"
          },
          {
            "displayValue": "Female",
            "hashId": "1"
          }
        ],
        "isMandatory": true
      },
      {
        "type": "Text",
        "title": "Enter height",
        "keyName": "height",
        "keyboardType": "Number",
        "regex": "[0-9]+"
      },
      {
        "type": "Text",
        "title": "Enter weight",
        "keyName": "weight",
        "keyboardType": "Number",
        "regex": "[0-9]+"
      },
      {
        "type": "Text",
        "title": "Enter BP high",
        "keyName": "bpHigh",
        "keyboardType": "Decimal",
        "regex": "[0-9.]+"
      },
      {
        "type": "Text",
        "title": "Enter BP low",
        "keyName": "bpLow",
        "keyboardType": "Decimal",
        "regex": "[0-9.]+"
      },
      {
        "type": "Text",
        "title": "Enter cholesterol",
        "keyName": "cholesterol",
        "keyboardType": "Number",
        "regex": "[0-9]+"
      },
      {
        "type": "Text",
        "title": "Enter glucose",
        "keyName": "glucose",
        "keyboardType": "Number",
        "regex": "[0-9]+"
      },
      {
        "type": "Checkbox",
        "value": false,
        "title": "Do you smoke?",
        "keyName": "smoke"
      },
      {
        "type": "Checkbox",
        "value": false,
        "title": "Do you consume alcohol?",
        "keyName": "alcohol"
      },
      {
        "type": "Checkbox",
        "value": false,
        "title": "Are you active in daily routine?",
        "keyName": "active"
      },
      {
        "type": "Text",
        "title": "Enter BMI",
        "keyName": "bmi",
        "keyboardType": "Decimal",
        "regex": "[0-9.]+"
      }
    ]
  }
}
        """.trimIndent()