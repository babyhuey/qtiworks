/* Copyright (c) 2012-2013, University of Edinburgh.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice, this
 *   list of conditions and the following disclaimer in the documentation and/or
 *   other materials provided with the distribution.
 *
 * * Neither the name of the University of Edinburgh nor the names of its
 *   contributors may be used to endorse or promote products derived from this
 *   software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 * This software is derived from (and contains code from) QTItools and MathAssessEngine.
 * QTItools is (c) 2008, University of Southampton.
 * MathAssessEngine is (c) 2010, University of Edinburgh.
 */
package uk.ac.ed.ph.qtiworks.mathassess.glue.maxima;

import uk.ac.ed.ph.qtiworks.mathassess.glue.types.ValueWrapper;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests {@link QtiMaximaProcess#passQtiVariableToMaxima(String, ValueWrapper)} using the sample data
 * provided by {@link MaximaDataBindingSamples#CIRCULAR_EXAMPLES}
 *
 * @author David McKain
 */
@RunWith(Parameterized.class)
public class QtiMaximaSessionPassVariableTests extends QtiMaximaSessionTestBase {

    private static final Logger logger = LoggerFactory.getLogger(QtiMaximaSessionPassVariableTests.class);

    @Parameters
    public static Collection<Object[]> data() throws Exception {
        return MaximaDataBindingSamples.CIRCULAR_EXAMPLES;
    }

    @SuppressWarnings("unused")
    private final String maximaRepresentation;

    private final ValueWrapper valueWrapper;

    public QtiMaximaSessionPassVariableTests(final String maximaRepresentation, final ValueWrapper valueWrapper) {
        this.maximaRepresentation = maximaRepresentation;
        this.valueWrapper = valueWrapper;
    }

    @Test
    public void runTest() throws Exception {
        /* Set variable */
        process.passQtiVariableToMaxima("x", valueWrapper);

        /* Then we'll extract and check */
        final ValueWrapper variableChecked = process.executeStringOutput("x", false, valueWrapper.getClass());
        if (!valueWrapper.equals(variableChecked)) {
            logger.warn("Input: " + valueWrapper);
            logger.warn("Got:   " + variableChecked);
            Assert.assertEquals(valueWrapper, variableChecked);
        }
    }
}
