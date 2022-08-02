import express from 'express'

import userRouter from './user_router.js'

const app = express()

app.use('/user', userRouter)


app.listen(8888, () => {
    console.log('server is starting....')
})