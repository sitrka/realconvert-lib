/*
 * MIT License
 *
 * Copyright (c) 2018 Sitraka Ratsimba
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.strka.realconvert;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.strka.realconvert.type.unit.Celsius;
import com.github.strka.realconvert.type.unit.Kelvin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConverterTest {

  private Converter converter;
  private Celsius mockedCelsius;

  @Before
  public void setUp() {
    converter = new Converter();
    mockedCelsius = mock(Celsius.class);
    when(mockedCelsius.normalize()).thenReturn(new Kelvin());
  }

  @After
  public void tearDown() {
  }

  @Test
  public void convertShouldSetTheSourceUnit() {
    converter.convert(new Celsius());
    assertNotNull(converter.getSource());
  }

  @Test
  public void convertShouldReturnAConverter() {
    assertNotNull(converter.convert(new Celsius()));
  }

  @Test
  public void toShouldConvertSourceTheTarget() {
    Kelvin result = (Kelvin) converter.convert(new Celsius()).to(Kelvin.class);
    assertNotNull(result.getName());
  }

  /**
   * Does this test should be improved?
   */
  @Test
  public void toConvertAnUnitToAnotherOne() {
    converter.convert(mockedCelsius).to(Kelvin.class);
    verify(mockedCelsius).normalize();
  }

}