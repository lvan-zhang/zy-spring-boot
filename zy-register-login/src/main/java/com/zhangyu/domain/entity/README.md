## 说明
entity中的数据是和数据库一一对应的

比如：这里的SysUser就是数据库表sys_user，也就是用户信息

而注册接口，我们使用的 RegisterBody 是因为注册提交的数据可能比较少，后续用户更新自己的基本信息，比较全的数据都在 SysUser 里面