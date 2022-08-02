import express from "express";

import {getAllUser} from "./user_list.js";

//创建路由对象
const router = new express.Router()

//挂在路由规则
router.get('/list', getAllUser)

//es6导出
export default router