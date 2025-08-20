import NumberConverter from '../src/lib/conversor-numerico'
import { assert, expect } from 'chai'

describe('Number converter', () => {
  let numberConverter: NumberConverter

  beforeEach(() => {
    numberConverter = new NumberConverter()
  })

  it('passes an example test', () => {
    // CHOICE: either use assert or expect in your tests
    // https://www.chaijs.com/api/
    assert.instanceOf(numberConverter, NumberConverter)
    expect(numberConverter).to.be.an.instanceof(NumberConverter)
  })

  // TODO: Add test cases for the production code.
})
