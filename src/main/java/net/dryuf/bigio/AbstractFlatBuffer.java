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

/**
 * Partial implementation of {@link FlatBuffer}.
 */
public abstract class AbstractFlatBuffer extends FlatBuffer
{
	@Override
	public void close()
	{
	}

	@Override
	public FlatBuffer withByteOrder(ByteOrder byteOrder)
	{
		if (getByteOrder() == byteOrder)
			return this;
		return new SwappedBytesFlatBuffer(this);
	}

	@Override
	public void getBytes(long pos, byte[] data)
	{
		getBytes(pos, data, 0, data.length);
	}

	@Override
	public void putBytes(long pos, byte[] data)
	{
		putBytes(pos, data, 0, data.length);
	}

	@Override
	public FlatBuffer subBuffer(long pos, long length)
	{
		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public ByteBuffer getByteBuffer(long pos, long length)
	{
		throw new UnsupportedOperationException("TODO");
	}

	@Override
	public boolean equalsBytes(long pos, byte[] bytes, int offset, int length)
	{
		for (int i = 0; i < length; ++i) {
			byte bl = this.getByte(pos+i), br = bytes[offset+i];
			if (bl != br)
				return false;
		}
		return true;
	}

	@Override
	public boolean equalsBuffer(long pos, FlatBuffer buffer, long offset, long length)
	{
		for (long i = 0; i < length; ++i) {
			byte bl = this.getByte(pos+i), br = buffer.getByte(offset+i);
			if (bl != br)
				return false;
		}
		return true;
	}

	@Override
	public boolean equalsByteBuffer(long pos, ByteBuffer buffer)
	{
		for (int i = 0, offset = buffer.position(), length = buffer.remaining(); i < length; ++i) {
			byte bl = this.getByte(pos+i), br = buffer.get(offset+i);
			if (bl != br)
				return false;
		}
		return true;
	}

	@Override
	public int compareTo(FlatBuffer right)
	{
		long sl = this.size(), sr = right.size();
		for (long i = 0, size = Math.max(sl, sr); i < size; ++i) {
			byte bl = this.getByte(i), br = right.getByte(i);
			if (bl != br)
				return bl-br;
		}
		return sl < sr ? -1 : sr > 0 ? 1 : 0;
	}
}
