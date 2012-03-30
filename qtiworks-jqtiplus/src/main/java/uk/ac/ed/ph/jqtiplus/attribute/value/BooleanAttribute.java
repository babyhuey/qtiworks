/* Copyright (c) 2012, University of Edinburgh.
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
package uk.ac.ed.ph.jqtiplus.attribute.value;

import uk.ac.ed.ph.jqtiplus.attribute.EnumerateAttribute;
import uk.ac.ed.ph.jqtiplus.attribute.SingleAttribute;
import uk.ac.ed.ph.jqtiplus.node.XmlNode;
import uk.ac.ed.ph.jqtiplus.value.BooleanValue;

/**
 * Attribute with boolean value.
 * 
 * @author Jiri Kajaba
 */
public class BooleanAttribute extends SingleAttribute<Boolean> implements EnumerateAttribute<Boolean> {

    private static final long serialVersionUID = -6757069543350955429L;

    /** Supported values. */
    private static final Boolean[] values = new Boolean[] { Boolean.TRUE, Boolean.FALSE };

    public BooleanAttribute(XmlNode parent, String localName) {
        super(parent, localName);
    }

    public BooleanAttribute(XmlNode parent, String localName, Boolean defaultValue) {
        super(parent, localName, defaultValue);
    }

    public BooleanAttribute(XmlNode parent, String localName, Boolean defaultValue, Boolean value, boolean required) {
        super(parent, localName, defaultValue, value, required);
    }
    
    public BooleanAttribute(XmlNode parent, String localName, String namespaceUri, Boolean defaultValue, Boolean value, boolean required) {
        super(parent, localName, namespaceUri, defaultValue, value, required);
    }

    @Override
    protected Boolean parseValue(String value) {
        return BooleanValue.parseBoolean(value);
    }
    
    @Override
    protected String valueToString(Boolean value) {
        return value.toString();
    }

    /**
     * Gets all supported values of this attribute.
     * 
     * @return all supported values of this attribute
     */
    @Override
    public Boolean[] getSupportedValues() {
        return values;
    }
}
