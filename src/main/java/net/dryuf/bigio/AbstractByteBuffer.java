/*
 * Copyright 2015 Zbynek Vyskovsky mailto:kvr000@gmail.com http://kvr.znj.cz/ http://github.com/kvr000/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dryuf.bigio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;


/**
 * Partial implementation of {@link ByteBuffer}.
 */
public class AbstractByteBuffer extends ByteBuffer
{
	@Override
	public ByteBuffer slice()
	{
		return null;
	}

	@Override
	public ByteBuffer duplicate()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public ByteBuffer asReadOnlyBuffer()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public byte get()
	{
		checkBounds(position, 1);
		return 0;
	}

	@Override
	public ByteBuffer put(byte b)
	{
		checkBounds(position, 1, limit);
		return null;
	}

	@Override
	public byte get(int index)
	{
		checkBounds(position, 1, limit);
		return 0;
	}

	@Override
	public ByteBuffer compact()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isReadOnly()
	{
		return false;
	}

	@Override
	public boolean isDirect()
	{
		return false;
	}

	@Override
	public char getChar()
	{
		return 0;
	}

	@Override
	public ByteBuffer putChar(char value)
	{
		return null;
	}

	@Override
	public char getChar(int index)
	{
		return 0;
	}

	@Override
	public ByteBuffer putChar(int index, char value)
	{
		return null;
	}

	@Override
	public CharBuffer asCharBuffer()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public short getShort()
	{
		return 0;
	}

	@Override
	public ByteBuffer putShort(short value)
	{
		return null;
	}

	@Override
	public short getShort(int index)
	{
		return 0;
	}

	@Override
	public ByteBuffer putShort(int index, short value)
	{
		return null;
	}

	@Override
	public ShortBuffer asShortBuffer()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public int getInt()
	{
		return 0;
	}

	@Override
	public ByteBuffer putInt(int value)
	{
		return null;
	}

	@Override
	public int getInt(int index)
	{
		return 0;
	}

	@Override
	public ByteBuffer putInt(int index, int value)
	{
		return null;
	}

	@Override
	public IntBuffer asIntBuffer()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public long getLong()
	{
		return 0;
	}

	@Override
	public ByteBuffer putLong(long value)
	{
		return null;
	}

	@Override
	public long getLong(int index)
	{
		return 0;
	}

	@Override
	public ByteBuffer putLong(int index, long value)
	{
		return null;
	}

	@Override
	public LongBuffer asLongBuffer()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public float getFloat()
	{
		return 0;
	}

	@Override
	public ByteBuffer putFloat(float value)
	{
		return null;
	}

	@Override
	public float getFloat(int index)
	{
		return 0;
	}

	@Override
	public ByteBuffer putFloat(int index, float value)
	{
		return null;
	}

	@Override
	public FloatBuffer asFloatBuffer()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public double getDouble()
	{
		return 0;
	}

	@Override
	public ByteBuffer putDouble(double value)
	{
		return null;
	}

	@Override
	public double getDouble(int index)
	{
		return 0;
	}

	@Override
	public ByteBuffer putDouble(int index, double value)
	{
		return null;
	}

	@Override
	public DoubleBuffer asDoubleBuffer()
	{
		throw new UnsupportedOperationException();
	}

	private final void ensureLength(long length)
	{
		if ((length|position+length|(limit-length-position)) < 0) {
			ensureLengthExtend(length);
		}
	}

	protected void ensureLengthExtend(long length)
	{
		throw new IndexOutOfBoundsException();
	}

	public static void checkBounds(long pos, long length, long limit)
	{
		if ((pos|length|(pos+length)|(limit-length-pos)) < 0) {
			throw new IndexOutOfBoundsException();
		}
	}

	private long position;

	private long limit;
}
