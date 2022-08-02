const HtmlPlugin = require('html-webpack-plugin')

const htmlPlugin = new HtmlPlugin({
    template: './src/index.html',
    filename: './index.html'
})

const {CleanWebpackPlugin} = require('clean-webpack-plugin')
const cleanPlugin = new CleanWebpackPlugin()

module.exports = {
    mode: 'development',
    // eval-source-map 仅限在开发模式下使用
    // devtool: 'eval-source-map',
    // 生产环境下，建议关闭 SourceMap 或将 devtool 的值设置为 nosources-source-map
    // devtool: 'nosources-source-map',
    // devtool: 'source-map',
    plugins: [htmlPlugin, cleanPlugin],
    devServer: {
        open: true,
        host: '127.0.0.1',
        port: 80
    },
    module: {
        rules: [
            {test: /\.css$/, use: ['style-loader', 'css-loader']},
            {test: /\.less$/, use: ['style-loader', 'css-loader', 'less-loader']},
            // { test: /\.jpg|png|gif$/, use: 'url-loader?limit=22228' }
            {
                test: /\.jpg|png|gif$/,
                use: {
                    loader: 'url-loader',
                    options: {
                        limit: 22228,
                        outputPath: 'image',
                    },
                },
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        plugins: ['@babel/plugin-proposal-class-properties'],
                    },
                },
            },
        ],
    },
}

