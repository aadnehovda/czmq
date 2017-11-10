################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
import utils
from . import destructors
libczmq_destructors = destructors.lib

class Zarmour(object):
    """
    armoured text encoding and decoding
    """

    def __init__(self):
        """
        Create a new zarmour
        """
        p = utils.lib.zarmour_new()
        if p == utils.ffi.NULL:
            raise MemoryError("Could not allocate person")

        # ffi.gc returns a copy of the cdata object which will have the
        # destructor called when the Python object is GC'd:
        # https://cffi.readthedocs.org/en/latest/using.html#ffi-interface
        self._p = utils.ffi.gc(p, libczmq_destructors.zarmour_destroy_py)

    def encode(self, data, size):
        """
        Encode a stream of bytes into an armoured string. Returns the armoured
        string, or NULL if there was insufficient memory available to allocate
        a new string.
        """
        return utils.lib.zarmour_encode(self._p, data, size)

    def decode(self, data):
        """
        Decode an armoured string into a chunk. The decoded output is
        null-terminated, so it may be treated as a string, if that's what
        it was prior to encoding.
        """
        return utils.lib.zarmour_decode(self._p, utils.to_bytes(data))

    def mode(self):
        """
        Get the mode property.
        """
        return utils.lib.zarmour_mode(self._p)

    def mode_str(self):
        """
        Get printable string for mode.
        """
        return utils.lib.zarmour_mode_str(self._p)

    def set_mode(self, mode):
        """
        Set the mode property.
        """
        return utils.lib.zarmour_set_mode(self._p, mode)

    def pad(self):
        """
        Return true if padding is turned on.
        """
        return utils.lib.zarmour_pad(self._p)

    def set_pad(self, pad):
        """
        Turn padding on or off. Default is on.
        """
        return utils.lib.zarmour_set_pad(self._p, pad)

    def pad_char(self):
        """
        Get the padding character.
        """
        return utils.lib.zarmour_pad_char(self._p)

    def set_pad_char(self, pad_char):
        """
        Set the padding character.
        """
        return utils.lib.zarmour_set_pad_char(self._p, pad_char._p)

    def line_breaks(self):
        """
        Return if splitting output into lines is turned on. Default is off.
        """
        return utils.lib.zarmour_line_breaks(self._p)

    def set_line_breaks(self, line_breaks):
        """
        Turn splitting output into lines on or off.
        """
        return utils.lib.zarmour_set_line_breaks(self._p, line_breaks)

    def line_length(self):
        """
        Get the line length used for splitting lines.
        """
        return utils.lib.zarmour_line_length(self._p)

    def set_line_length(self, line_length):
        """
        Set the line length used for splitting lines.
        """
        return utils.lib.zarmour_set_line_length(self._p, line_length)

    def print_py(self):
        """
        Print properties of object
        """
        return utils.lib.zarmour_print(self._p)

    def test(verbose):
        """
        Self test of this class.
        """
        return utils.lib.zarmour_test(verbose)

################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
