# Vacation Calculate Service API

## Overview
Microservice for calculating vacation payments based on:
- Average daily earnings
- Vacation duration (in days or date range)
- Automatic exclusion of holidays and weekends

## Base URL
`http://localhost:7777`

## API Endpoints

### GET /calculate
Calculate vacation pay amount.

#### Parameters
| Parameter      | Type   | Required | Description                     | Example       |
|----------------|--------|----------|---------------------------------|---------------|
| salary         | double | Yes      | Monthly salary                  | 85000         |
| days           | integer| No*      | Vacation duration in days       | 14            |
| start          | string | No*      | Start date (DD.MM.YYYY)         | 01.01.2025    |
| end (excluded) | string | No*      | End date (DD.MM.YYYY)           | 14.01.2025    |

> **\* Note about optional parameters:**  
> You must provide EITHER:
> - `days` parameter (for simple calculation by days)  
> OR  
> - Both `start` AND `end` parameters (for date range calculation with holiday and weekend exclusion) 
> 
> If neither condition is met, the API will return 400 Bad Request error.
