const Roman = new Map([
  ['M', 1000],
  ['D', 500],
  ['C', 100],
  ['L', 50],
  ['X', 10],
  ['V', 5],
  ['I', 1]
])

// Roman numerals only go up to 3999 (MMMCMXCIX)
const ROMAN_NUMERAL_REGEX = /^(?=[MDCLXVI])(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$/

export default class NumberConverter {
  romanToArabic(romanNumeral: string): number {
    const ERROR_VALUE = -1

    romanNumeral = romanNumeral.trim().toUpperCase()
    if (this.isInvalidRoman(romanNumeral)) {
      return ERROR_VALUE
    }
    return this.convertRomanToArabic(romanNumeral)
  }

  private convertRomanToArabic(romanNumeral: string): number {
    return this.calculateUpToLastSymbol(romanNumeral) + this.valueOfLastSymbol(romanNumeral)
  }

  private isInvalidRoman(romanNumeral: string): boolean {
    return !romanNumeral.match(ROMAN_NUMERAL_REGEX)
  }

  private calculateUpToLastSymbol(romanNumeral: string): number {
    let sum = 0
    const indexOfPenultimateSymbol = romanNumeral.length - 2

    for (let i = 0; i <= indexOfPenultimateSymbol; i++) {
      const current = Roman.get(romanNumeral[i]) as number
      const next = Roman.get(romanNumeral[i + 1]) as number

      if (current < next) {
        sum -= current
      } else {
        sum += current
      }
    }

    return sum
  }

  private valueOfLastSymbol(romanNumeral: string): number {
    const i = romanNumeral.length - 1
    const number = Roman.get(romanNumeral[i]) as number

    return number
  }
}
