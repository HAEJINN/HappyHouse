<template>
  <div>
    <span>{{ rank.aptname }}</span>
    <span>{{ rank.dealamount }}</span>
  </div>
</template>

<script>
export default {
  name: 'row',
  props: ['rank'],
};
</script>
