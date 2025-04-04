# coding=utf-8
# *** WARNING: this file was generated by pulumi-language-python. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

from . import _utilities
import typing
# Export this package's modules as members:
from .provider import *

# Make subpackages available:
if typing.TYPE_CHECKING:
    import mjeffryes_command.local as __local
    local = __local
    import mjeffryes_command.remote as __remote
    remote = __remote
else:
    local = _utilities.lazy_import('mjeffryes_command.local')
    remote = _utilities.lazy_import('mjeffryes_command.remote')

_utilities.register(
    resource_modules="""
[
 {
  "pkg": "command",
  "mod": "local",
  "fqn": "mjeffryes_command.local",
  "classes": {
   "command:local:Command": "Command"
  }
 },
 {
  "pkg": "command",
  "mod": "remote",
  "fqn": "mjeffryes_command.remote",
  "classes": {
   "command:remote:Command": "Command",
   "command:remote:CopyFile": "CopyFile",
   "command:remote:CopyToRemote": "CopyToRemote"
  }
 }
]
""",
    resource_packages="""
[
 {
  "pkg": "command",
  "token": "pulumi:providers:command",
  "fqn": "mjeffryes_command",
  "class": "Provider"
 }
]
"""
)
