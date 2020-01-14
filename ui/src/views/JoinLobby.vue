<template>
    <div>
        <GameCodePanel />
        <PlayersPanel />
        <v-card-text>Waiting for game to start...</v-card-text>
    </div>
</template>
<script>
import GameCodePanel from "../components/GameCodePanel.vue";
import PlayersPanel from "../components/PlayersPanel.vue"

export default {
    components: {GameCodePanel, PlayersPanel},
};
</script>

<style>
</style>