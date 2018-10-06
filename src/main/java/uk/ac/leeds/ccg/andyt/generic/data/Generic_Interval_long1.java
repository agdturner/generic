/*
 * Copyright (C) 2018 geoagdt.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package uk.ac.leeds.ccg.andyt.generic.data;

import java.io.Serializable;

/**
 *
 * @author geoagdt
 */
public class Generic_Interval_long1 implements Serializable, Comparable {

    /**
     * Stores the lower bound.
     */
    private final long L;

    /**
     * Stores the upper bound.
     */
    private final long U;

    public Generic_Interval_long1(long l, long u) {
        L = l;
        U = u;
    }

    @Override
    public String toString() {
        return "[" + L + ", " + U + ")";
    }

    /**
     * l is in the interval if it is greater than or equal to L and less than U.
     *
     * @param l
     * @return
     */
    public boolean isInInterval(long l) {
        return l >= L && l < U;
    }

    /**
     * @return the L
     */
    public long getL() {
        return L;
    }

    /**
     * @return the U
     */
    public long getU() {
        return U;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Generic_Interval_long1) {
            Generic_Interval_long1 obj;
            obj = (Generic_Interval_long1) o;
            if (this.L < obj.L) {
                return -1;
            } else {
                if (this.L > obj.L) {
                    return 1;
                }
                if (this.U < obj.U) {
                    return -1;
                } else {
                    if (this.U > obj.U) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        } else {
            return -1;
        }
    }

}
