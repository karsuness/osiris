<template>
  <div class="number-container d-flex justify-content-center align-items-center">
    <!-- 减 1 的按钮 -->
    <button type="button" class="btn btn-light btn-sm" @click="sub" v-if="count !== 0">-</button>
    <!-- 购买的数量 -->
    <span class="number-box">{{ count }}</span>
    <!-- 加 1 的按钮 -->
    <button type="button" class="btn btn-light btn-sm" @click="add">+</button>
  </div>
</template>

<script>
import eventBus from "@/components/eventBus.js";

export default {
  props: {
    id: {
      required: true,
      type: Number
    },

    // 商品的数量
    count: {
      type: Number,
      default: 0
    }
  },

  methods: {
    // 减 1
    sub() {
      if (this.count - 1 < 0) return;
      eventBus.$emit('share', this.id, this.count - 1)
    },

    // 加 1
    add() {
      eventBus.$emit('share', this.id, this.count + 1)
    }
  }
}
</script>

<style lang="less" scoped>
.number-box {
  min-width: 30px;
  text-align: center;
  margin: 0 5px;
  font-size: 12px;
}

.btn-sm {
  width: 30px;
}
</style>
